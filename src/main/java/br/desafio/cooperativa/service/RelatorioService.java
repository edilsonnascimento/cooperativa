package br.desafio.cooperativa.service;

import br.desafio.cooperativa.dto.CooperadoResponseDto;
import br.desafio.cooperativa.repositoy.CooperadoRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RelatorioService {

    @Autowired
    private CooperadoRepository repository;

    public String exportRelatorio(String formatoRelatorio) throws JRException, FileNotFoundException {
        List<CooperadoResponseDto> cooperados = CooperadoResponseDto.converter(repository.findAll());
        String path = "C:\\temp\\";
        String nomeRelatorio = "cooperados.";
        File file = ResourceUtils.getFile("classpath:cooperados.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(cooperados);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Edilson do Nascimento");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if(formatoRelatorio.equals("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + nomeRelatorio + formatoRelatorio);
        }
        if(formatoRelatorio.equals("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + nomeRelatorio + formatoRelatorio);
        }
        return "Relatrio gerado no " + path;
    }
}
