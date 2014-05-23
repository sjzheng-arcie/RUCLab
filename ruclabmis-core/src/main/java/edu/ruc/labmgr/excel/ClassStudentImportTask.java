package edu.ruc.labmgr.excel;

import edu.ruc.labmgr.domain.ClassStudent;
import edu.ruc.labmgr.domain.Curriculum;
import edu.ruc.labmgr.domain.Student;
import edu.ruc.labmgr.service.CurriculumClassService;
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

public class ClassStudentImportTask implements Callable<Boolean> {

    private File excelFile;
    private boolean clean;
    private Integer vcId;

    public ClassStudentImportTask(File excelFile, boolean clean,Integer vcId) {
        this.excelFile = excelFile;
        this.clean = clean;
        this.vcId = vcId;
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
           ClassStudentExcelParser parser = new ClassStudentExcelParser();
            List<ClassStudent> students = parser.parseFromWorkBook(wb);
            CurriculumClassService curriculumClassService = SysUtil.getBean("curriculumClassService",CurriculumClassService.class);

            curriculumClassService.addStudentToClassBySn(this.vcId, students);


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
