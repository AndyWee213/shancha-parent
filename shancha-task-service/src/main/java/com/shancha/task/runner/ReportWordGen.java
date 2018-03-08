package com.shancha.task.runner;

import com.shancha.task.bean.AuctioningItemBean;
import com.shancha.task.model.AuctioningItem;
import com.shancha.task.service.AuctioningItemService;
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

@Component
public class ReportWordGen implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(ReportWordGen.class);

    @Autowired
    AuctioningItemService service;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Report generation task start.");
        List<AuctioningItem> auctioningItems = service.getAllAuctioningItemCrawledToday();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("YYYY年MM月dd日HH时");

        List<AuctioningItemBean> beans = new ArrayList<>();
        for (AuctioningItem item : auctioningItems) {
            AuctioningItemBean bean = new AuctioningItemBean();
            bean.setTitle(item.getTitle());
            bean.setSellOrg(item.getSellOrg());
            bean.setSellStart(df.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(item.getSellStart() / 1000), ZoneId.of("Asia/Shanghai"))));
            bean.setSellEnd(df.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(item.getSellEnd() / 1000), ZoneId.of("Asia/Shanghai"))));
            bean.setUrl(item.getUrl());
            bean.setValuation(item.getValuation());
            beans.add(bean);
        }


        JAXBContext context = JAXBContext.newInstance(AuctioningItemBean.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        for (AuctioningItemBean bean : beans) {
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
