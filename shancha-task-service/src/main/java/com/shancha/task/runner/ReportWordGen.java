package com.shancha.task.runner;

import com.shancha.task.bean.CommunityExtBean;
import com.shancha.task.bean.ReportDataBean;
import com.shancha.task.enums.CommunityExtensionTypeEnum;
import com.shancha.task.model.AuctioningItem;
import com.shancha.task.model.Community;
import com.shancha.task.model.CommunityExtension;
import com.shancha.task.service.AuctioningItemService;
import com.shancha.task.service.CommunityExtensionService;
import com.shancha.task.service.CommunityService;
import org.apache.commons.lang3.StringUtils;
import org.docx4j.Docx4J;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.StringWriter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ReportWordGen implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(ReportWordGen.class);

    @Autowired
    AuctioningItemService auctioningItemService;

    @Autowired
    CommunityService communityService;

    @Autowired
    CommunityExtensionService communityExtensionService;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Report generation task start.");
        List<AuctioningItem> auctioningItems = auctioningItemService.getAllAuctioningItemCrawledToday();
        List<String> ids = new ArrayList<>();
        auctioningItems.forEach(p -> ids.add(p.getCommunityId()));
        List<Community> communities = communityService.getCommunitiesByCommunityIds(ids);
        Map<String, Community> communityMap = communities.stream().collect(Collectors.toMap(Community::getId, Function.identity()));
        List<CommunityExtension> communityExtensions = communityExtensionService.getCommunityExtensionByCommunityIds(communityMap.keySet());
        Map<String, List<CommunityExtension>> commExtMap = communityExtensions.stream().collect(
                Collectors.groupingBy(CommunityExtension::getCommunityId,
                        Collectors.mapping(Function.identity(), Collectors.toList())));

        DateTimeFormatter df = DateTimeFormatter.ofPattern("YYYY年MM月dd日HH时");
        List<ReportDataBean> beans = new ArrayList<>();
        for (AuctioningItem item : auctioningItems) {
            ReportDataBean bean = new ReportDataBean();
            bean.setTitle(item.getTitle());
            bean.setSellOrg(item.getSellOrg());
            bean.setSellStart(df.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(item.getSellStart()), ZoneId.of("Asia/Shanghai"))));
            bean.setSellEnd(df.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(item.getSellEnd()), ZoneId.of("Asia/Shanghai"))));
            bean.setUrl(item.getUrl());
            bean.setValuation(item.getValuation());

            //添加小区信息
            Community community = communityMap.get(item.getCommunityId());
            String buildingCount;
            String familyCount;
            if (community != null) {
                bean.setBuildingType(community.getBuildingType() == null ? "暂无数据" : community.getBuildingType());
                bean.setBuildingYear(community.getBuildingYear() == null ? "暂无数据" : community.getBuildingYear());
                buildingCount = community.getBuildingCount() == null ? "" : community.getBuildingCount();
                familyCount = community.getFamilyCount() == null ? "" : community.getFamilyCount();
                if (StringUtils.isEmpty(buildingCount) && StringUtils.isEmpty(familyCount)) {
                    bean.setCountInfo("暂无数据");
                } else if (StringUtils.isEmpty(buildingCount) || StringUtils.isEmpty(familyCount)) {
                    bean.setCountInfo(StringUtils.isEmpty(buildingCount) ? familyCount : buildingCount);
                } else {
                    bean.setCountInfo(buildingCount.concat("/").concat(familyCount));
                }
                bean.setDevelopeCompany(community.getDeveloperCompany() == null ? "暂无数据" : community.getDeveloperCompany());
                bean.setElevator(community.getElevator() == null ? "暂无数据" : community.getElevator());
                bean.setGreeningRatio(community.getGreeningRate() == null ? "暂无数据" : community.getGreeningRate());
                bean.setPlate(community.getPlate() == null ? "暂无数据" : community.getPlate());
                bean.setPlotRatio(community.getPlotRation() == null ? "暂无数据" : community.getPlotRation());
                bean.setPorking(community.getPorking() == null ? "暂无数据" : community.getPorking());
                bean.setPosition(community.getPosition() == null ? "暂无数据" : community.getPosition());
                bean.setPropertyCompany(community.getPropertyCompany() == null ? "暂无数据" : community.getPropertyCompany());
                bean.setPropertyPrice(community.getPropertyPrice() == null ? "暂无数据" : community.getPropertyPrice());
            }
            List<CommunityExtBean> kindergartens = new ArrayList<>();
            bean.setKindergartens(kindergartens);
            List<CommunityExtBean> primarySchools = new ArrayList<>();
            bean.setPrimarySchools(primarySchools);
            List<CommunityExtBean> secondarySchools = new ArrayList<>();
            bean.setSecondarySchools(secondarySchools);
            List<CommunityExtBean> hospitals = new ArrayList<>();
            bean.setHospitals(hospitals);
            List<CommunityExtBean> busStations = new ArrayList<>();
            bean.setBusStations(busStations);
            List<CommunityExtBean> subwayStations = new ArrayList<>();
            bean.setSubwayStations(subwayStations);
            List<CommunityExtBean> shoppingMalls = new ArrayList<>();
            bean.setShoppingMalls(shoppingMalls);
            List<CommunityExtBean> parks = new ArrayList<>();
            bean.setParks(parks);
            if (commExtMap.containsKey(community.getId())) {
                for (CommunityExtension extension : commExtMap.get(community.getId())) {
                    CommunityExtBean communityExtBean = new CommunityExtBean();
                    communityExtBean.setName(extension.getName());
                    communityExtBean.setDistance(extension.getDistance());
                    switch (CommunityExtensionTypeEnum.getByCode(extension.getType())) {
                        case KINDERGARTEN:
                            kindergartens.add(communityExtBean);
                            break;
                        case PRIMARY_SCHOOL:
                            primarySchools.add(communityExtBean);
                            break;
                        case SECONDARY_SCHOOL:
                            secondarySchools.add(communityExtBean);
                            break;
                        case HOSPITAL:
                            hospitals.add(communityExtBean);
                            break;
                        case BUS_STATION:
                            busStations.add(communityExtBean);
                            break;
                        case SUB_WAY:
                            subwayStations.add(communityExtBean);
                            break;
                        case SHOPPING_MALL:
                            shoppingMalls.add(communityExtBean);
                            break;
                        case PARK:
                            parks.add(communityExtBean);
                            break;
                        default:
                            break;
                    }
                }
            }
            beans.add(bean);
        }

        JAXBContext context = JAXBContext.newInstance(ReportDataBean.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        for (ReportDataBean bean : beans) {
            StringWriter writer = new StringWriter();
            // generate xml string
            marshaller.marshal(bean, writer);
            logger.info(writer.toString());

//            Resource resource = new ClassPathResource("report/report.docx");
//            WordprocessingMLPackage wordMLPackage = Docx4J.load(resource.getInputStream());
//            Docx4J.bind(wordMLPackage, writer.toString(), Docx4J.FLAG_BIND_INSERT_XML & Docx4J.FLAG_BIND_BIND_XML);
//            // generate word document
//            String OUTPUT_DOCX = System.getProperty("user.dir") + "/" + bean.getTitle() + ".docx";
//
//            Docx4J.save(wordMLPackage, new File(OUTPUT_DOCX), Docx4J.FLAG_NONE);
        }

        logger.info("Report generation task end.");
    }
}
