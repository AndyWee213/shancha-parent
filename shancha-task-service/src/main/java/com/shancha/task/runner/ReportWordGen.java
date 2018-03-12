package com.shancha.task.runner;

import com.shancha.task.bean.ReportDataBean;
import com.shancha.task.model.AuctioningItem;
import com.shancha.task.model.Community;
import com.shancha.task.service.AuctioningItemService;
import com.shancha.task.service.CommunityService;
import org.apache.http.auth.AUTH;
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
import java.util.HashMap;
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

    @Override
    public void run(String... args) throws Exception {
        logger.info("Report generation task start.");
        List<AuctioningItem> auctioningItems = auctioningItemService.getAllAuctioningItemCrawledToday();
        List<String> ids = new ArrayList<>();
        auctioningItems.forEach(p -> ids.add(p.getId()));
        List<Community> communities = communityService.getCommunitiesByCommunityIds(ids);
        Map<String, Community> communityMap = communities.stream().collect(Collectors.toMap(Community::getId, Function.identity()));

        DateTimeFormatter df = DateTimeFormatter.ofPattern("YYYY年MM月dd日HH时");
        List<ReportDataBean> beans = new ArrayList<>();
        for (AuctioningItem item : auctioningItems) {
            ReportDataBean bean = new ReportDataBean();
            bean.setTitle(item.getTitle());
            bean.setSellOrg(item.getSellOrg());
            bean.setSellStart(df.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(item.getSellStart() / 1000), ZoneId.of("Asia/Shanghai"))));
            bean.setSellEnd(df.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(item.getSellEnd() / 1000), ZoneId.of("Asia/Shanghai"))));
            bean.setUrl(item.getUrl());
            bean.setValuation(item.getValuation());
            beans.add(bean);
        }

        JAXBContext context = JAXBContext.newInstance(ReportDataBean.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        for (ReportDataBean bean : beans) {
            StringWriter writer = new StringWriter();
            // generate xml string
            marshaller.marshal(bean, writer);

            Resource resource = new ClassPathResource("report/report.docx");
            WordprocessingMLPackage wordMLPackage = Docx4J.load(resource.getInputStream());
            Docx4J.bind(wordMLPackage, writer.toString(), Docx4J.FLAG_BIND_INSERT_XML & Docx4J.FLAG_BIND_BIND_XML);
            // generate word document
            String OUTPUT_DOCX = System.getProperty("user.dir") + "/" + bean.getTitle() + ".docx";

            Docx4J.save(wordMLPackage, new File(OUTPUT_DOCX), Docx4J.FLAG_NONE);
        }

        logger.info("Report generation task end.");
    }
}
