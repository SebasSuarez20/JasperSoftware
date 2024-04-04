
package com.example.Services;

import com.example.Interfaz.IDo;
import com.example.Model.responseGeneric;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.stereotype.Service;

@Service
public class DoServices implements IDo{

    private DataSource dataSource;
    public Map<String, Object> params = new HashMap<>();
    
    public DoServices(DataSource _dataSource) {
        this.dataSource = _dataSource;
    }

    @Override
    public responseGeneric generalInforme(String path,int companyCode,int doNo) {
        
        
        try {
            JasperReport report = JasperCompileManager.compileReport(url+path);
            
            params.put("companyCode",companyCode);
            params.put("doNo",doNo);
            
            // Rellenar el informe con datos y generar JasperPrint
            //JasperPrint print = JasperFillManager.fillReport(report, params, new JREmptyDataSource());
            JasperPrint print = JasperFillManager.fillReport(report, params,dataSource.getConnection());
            
               // Exportar el informe a PDF
            ByteArrayOutputStream generatePdf = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(print, generatePdf);
            byte[] reportBytes = generatePdf.toByteArray();
            generatePdf.close();
            
            String base64Encoded = Base64.getEncoder().encodeToString(reportBytes);

            if(dataSource.getConnection()!=null) System.out.println("Success: Se connecto correctamente");
            else System.out.println("Error: No se conecto correctamente.");
            
            responseGeneric response = new responseGeneric("sucess: Se genero correctamente.",200,base64Encoded);
            return response;
        } catch (Exception e) {
            responseGeneric response = new responseGeneric("Error: "+e.getMessage(),400,null);
            return response;
        }
    }
    
    
    
}
