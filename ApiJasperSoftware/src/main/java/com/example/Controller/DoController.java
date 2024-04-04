
package com.example.Controller;

import com.example.Interfaz.IDo;
import com.example.Model.responseGeneric;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/services")
public class DoController {

    
    @Autowired
    private IDo _servicesDO;
    ObjectMapper objectMapper;
    
    public DoController(IDo servicesDO,ObjectMapper _objMapper) {
        this._servicesDO = servicesDO;
        this.objectMapper = _objMapper;
    }
    
    @GetMapping("generalInforme")
    public String result(@RequestParam int companyCode,@RequestParam int doNo) throws JsonProcessingException{
        return objectMapper.writeValueAsString(_servicesDO.generalInforme("/PrintDO.jrxml", companyCode, doNo));
    }
    
}
