package com.hzero.chenglu.unit.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 解析导出的Excel文件
 * 注：需根据实际需求做代码更改
 *
 * @author 【】
 */
public class ImportExcelUtil {
    /*
     * 导入Excel文件
     * @param obj   导入文件数据对应的实体类
     * @param request   HttpServletRequest请求request
     * @return  解析后数据集合
     */
    public List<Object> importExcel(Object obj, HttpServletRequest request) throws IOException, IllegalAccessException {
        // 将请求转化为多部件的请求
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        // 解析多部件请求文件
        MultipartFile mFile = multipartRequest.getFile("importFile");
        // 获得上传文件的文件名
        String fileName = mFile.getOriginalFilename();
        // 获取文件扩展名
        String eName = fileName.substring(fileName.lastIndexOf(".") + 1);
        InputStream inputStream = mFile.getInputStream();
        Workbook workbook = getWorkbook(inputStream, eName);
        // 获取工作薄第一张表
        Sheet sheet = workbook.getSheetAt(0);
        // 获取名称
        String sheetName = sheet.getSheetName().trim();
        // 获取第一行
        Row row = sheet.getRow(0);
        // 获取有效单元格数
        int cellNum = row.getPhysicalNumberOfCells();
        // 表头集合
        List<String> headList = new ArrayList<>();
        for (int i = 0; i < cellNum; i++) {
            Cell cell = row.getCell(i);
            String val = cell.getStringCellValue();
            headList.add(val);
        }
//        Map<String, Field> map = getObjComment(obj);
        Map<String, Field> map = null;
        // 获得有效行数
        int rowNum = sheet.getPhysicalNumberOfRows();
        // 定义导出文件中数据集合
        List<Object> objList = new ArrayList<>();
        for (int i = 1; i < rowNum; i++) {
            row = sheet.getRow(i);
            Object data = new Object();
            for (int j = 0; j < headList.size(); j++) {
                // 解析单元格
                Cell cell = row.getCell(j);
                // 根据字段给字段设值(根据实际需求更改代码)
                Field field = map.get(headList.get(j));
                field.setAccessible(true);
                field.set(data, cell.getStringCellValue());
            }
            objList.add(data);
        }

        return objList;
    }

    /*
     * 利用java反射机制获取该类及父类的字段@Comment("")注解和字段信息Map集合
     */
//    public Map<String, Field> getObjComment(Object obj) {
//        Map<String, Field> map = new HashMap<>();
//        // 获取该类所有字段信息
//        Field[] fields = obj.getClass().getDeclaredFields();
//        for (Field field : fields) {
//            Comment comment = field.getAnnotation(Comment.class);
//            if (null == comment) {
//                continue;
//            }
//            if (StringUtils.isNotBlank(comment.value())) {
//                map.put(comment.value(), field);
//            }
//        }
//        // 获取其父类所有属性（字段信息）
//        Field[] superFields = obj.getClass().getSuperclass().getDeclaredFields();
//        for (Field field : superFields) {
//            Comment comment = field.getAnnotation(Comment.class);
//            if (null == comment) {
//                continue;
//            }
//            if (StringUtils.isNotBlank(comment.value())) {
//                map.put(comment.value(), field);
//            }
//        }
//        return map;
//    }

    /*
     * 根据excel文件格式获知excel版本信息
     */
    public static Workbook getWorkbook(InputStream fs, String str) {
        Workbook book = null;
        try {
            if ("xls".equals(str)) {
                // 2003
                book = new HSSFWorkbook(fs);
            } else {
                // 2007
                book = new XSSFWorkbook(fs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

}
