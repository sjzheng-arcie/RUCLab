package edu.ruc.labmgr.excel;

import edu.ruc.labmgr.domain.Curriculum;
import edu.ruc.labmgr.service.CurriculumService;
import edu.ruc.labmgr.utils.SysUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.Callable;

public class CurriculumImportTask implements Callable<Boolean> {

    private File excelFile;
    private boolean clean;

    public CurriculumImportTask(File excelFile, boolean clean) {
        this.excelFile = excelFile;
        this.clean = clean;
    }

    @Override
    public Boolean call() throws Exception {
        InputStream is = null;
        try {
            is = new FileInputStream(excelFile);
            Workbook wb = null;
            if (excelFile.getName().endsWith("xls")) {
                wb = new HSSFWorkbook(is);
            } else {
                wb = new XSSFWorkbook(is);
            }
            CurriculumExcelParser parser = new CurriculumExcelParser();
            List<Curriculum> curriculums = parser.parseFromWorkBook(wb);
            CurriculumService curriculumService = SysUtil.getBean("curriculumService", CurriculumService.class);
            curriculumService.saveOrUpdateCurriculum(curriculums);


            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }
}
