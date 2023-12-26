package com.park.ex;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class Excel {
	
	@Autowired
	RequestParamMethod requestParamMethod;
	
	@RequestMapping(value = "/ExcelUpload", method = RequestMethod.POST)
	public String jang(@RequestParam("file") MultipartFile[] files , HttpServletRequest request , @ModelAttribute MemberVo memberVo,Model model) throws InvalidFormatException, IOException {
		
		Map<String, Object> map = requestParamMethod.requestToMap(request);
		List<List<String>> fileCellList = new ArrayList<List<String>>();
		
		for(MultipartFile file : files) {
			List<String> cellValueList = new ArrayList<String>();
			String fileName = file.getOriginalFilename();
			String extension = fileName.substring(fileName.lastIndexOf('.') + 1 );
			
			//확장자에 따라 읽는다.
			Workbook workbook = null;
			if("xlsx".equalsIgnoreCase(extension)) {
				OPCPackage opcPackage = OPCPackage.open(file.getInputStream());
				workbook = new XSSFWorkbook(opcPackage);
				opcPackage.close();
			}else {
				workbook = new HSSFWorkbook(file.getInputStream());
			}
			
			Sheet sheet = null;
			
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			    String sheetName = workbook.getSheetName(i);
			    if (sheetName.contains("C") && sheetName.contains("Invoice") && !Pattern.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*", sheetName)) {
			        sheet = workbook.getSheet(sheetName);
			        break;
			    }
			}
			
			//첫번째 시트만 읽는다.
			
			if(!map.get("row").equals("") && !map.get("cell").equals("")) {
				int[] rows = {8,12,13};
				int[] cells = {0,1,2};
				
				for(int i=0; i<cells.length; i++) {
					int rowNum = rows[i];
					
					for(int j =0; j<cells.length; j++) {
						int cellNum = cells[j];
						String cellValue = "";
						if(sheet == null) {
							continue;
						}
						Row row = sheet.getRow(rowNum);
						Cell cell = row.getCell(cellNum);
						
						if(cell != null) {
							// 셀 타입에 따라 처리 방식이 다르다
							switch(cell.getCellType()) {
							case STRING:
								cellValue += cell.getStringCellValue();
								break;
							case NUMERIC:
								cellValue += String.valueOf(cell.getNumericCellValue());
								break;
							case BOOLEAN:
								cellValue += String.valueOf(cell.getBooleanCellValue());
								break;
							case FORMULA:
								cellValue += String.valueOf(cell.getCellFormula());
								break;
							default:
								cellValue = cell.getRichStringCellValue().getString();
							}
							
							if(!cellValue.equals("")) {
								cellValueList.add(cellValue);
							}
						}
					}
					
				}
			}else {
				// 전부 읽기 
//				for(Row row : sheet) {
//					for(Cell cell : row) {
//						// 셀 타입에 따라 처리 방식이 다르다
//						switch(cell.getCellType()) {
//						case STRING:
//							System.out.print(cell.getStringCellValue() + "\t");
//							break;
//						case NUMERIC:
//							System.out.print(cell.getNumericCellValue() + "\t");
//							break;
//						case BOOLEAN:
//							System.out.print(cell.getBooleanCellValue() + "\t");
//							break;
//						case FORMULA:
//							System.out.print(cell.getCellFormula() + "\t");
//							break;
//						default:
//							System.out.print("\t");
//						}
//					}
//					System.out.println();
//				}
			}
			
			cellValueList.add(0, fileName.substring(0, fileName.lastIndexOf('.')));
			fileCellList.add(cellValueList);
		}
		// 콘솔 출력
		for(int i = 0; i<fileCellList.size(); i++) {
			System.out.println(fileCellList.get(i));
		}
		
		  // 새로운 엑셀 워크북 생성
	      Workbook workbook = new XSSFWorkbook();
	      
	      // 워크북에 시트 생성
	      Sheet sheet =  workbook.createSheet("Sheet1");
	      for(int i =0; i<fileCellList.size(); i++) {
	    	  Row row = sheet.createRow(i);
	    	  
	    	  for(int j = 0; j<4; j++) {
	    		  
	    		  if(fileCellList.get(i).size() > j) {
	    			  Cell cell = row.createCell(j);
	    			  cell.setCellValue(fileCellList.get(i).get(j));
	    			  sheet.setColumnWidth(j, (cell.getStringCellValue().getBytes().length+2)*256); 
	    		  }
	    	  }
	      }
	      
	      // 엑셀 파일 저장 경로와 이름 지정
	      String filePath = "C:\\Users\\USER\\Desktop\\files\\test.xlsx";
	      
	      try {
	         // 엑셀 파일 생성
	         FileOutputStream outputStream = new FileOutputStream(filePath);
	         workbook.write(outputStream);
	         workbook.close();
	         outputStream.close();
	         System.out.println("새로운 엑셀 파일이 생성되었습니다.");
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		
		
		return null;
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public String find(@RequestParam("file") MultipartFile[] files , HttpServletRequest request , @ModelAttribute MemberVo memberVo,Model model) throws InvalidFormatException, IOException {
		
		Map<String, Object> map = requestParamMethod.requestToMap(request);
		List<List<String>> fileCellList = new ArrayList<List<String>>();
		
		List<Row> rowList = new ArrayList<>();
		List<String> list = new ArrayList<String>();
		int count = 0;
		
		for(MultipartFile file : files) {
			List<String> cellValueList = new ArrayList<String>();
			String fileName = file.getOriginalFilename();
			String extension = fileName.substring(fileName.lastIndexOf('.') + 1 );
			
			//확장자에 따라 읽는다.
			Workbook workbook = null;
			if("xlsx".equalsIgnoreCase(extension)) {
				OPCPackage opcPackage = OPCPackage.open(file.getInputStream());
				workbook = new XSSFWorkbook(opcPackage);
				opcPackage.close();
			}else {
				workbook = new HSSFWorkbook(file.getInputStream());
			}
			
			Sheet sheet = null;
			
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			    String sheetName = workbook.getSheetName(i);
			    if (sheetName.contains("Main")) {
			        sheet = workbook.getSheet(sheetName);
			        break;
			    }
			}
			
			//첫번째 시트만 읽는다.
			rowList.add(sheet.getRow(0));
			if(!map.get("row").equals("") && !map.get("cell").equals("")) {
				// 전부 읽기 
				for(Row row : sheet) {
					for(Cell cell : row) {
						String cellValue = "";
						// 셀 타입에 따라 처리 방식이 다르다
						switch(cell.getCellType()) {
						case STRING:
							cellValue += cell.getStringCellValue();
							break;
						case NUMERIC:
							cellValue += String.valueOf(cell.getNumericCellValue());
							break;
						case BOOLEAN:
							cellValue += String.valueOf(cell.getBooleanCellValue());
							break;
						case FORMULA:
							cellValue += String.valueOf(cell.getCellFormula());
							break;
						default:
							cellValue = cell.getRichStringCellValue().getString();
						}
						if(!cellValue.equals("") && cell.getColumnIndex() == 2) {
							if(cellValue.trim().replace(" ", "").equalsIgnoreCase("Linh") || cellValue.trim().replace(" ", "").equalsIgnoreCase("Jia")) {
								rowList.add(row);
							}
						}else if(!cellValue.trim().replace(" ", "").equalsIgnoreCase("Linh") && !cellValue.trim().replace(" ", "").equalsIgnoreCase("Jia") && cell.getColumnIndex() == 2 && cell.getRowIndex() < 2168){
							count++;
						}
					}
				}
			}
		}
		System.out.println("size : " + rowList.size());
		System.out.println("공백 : " +count);
		  // 새로운 엑셀 워크북 생성
	      Workbook workbook = new XSSFWorkbook();
	      
	      // 워크북에 시트 생성
	      Sheet sheet =  workbook.createSheet("Sheet1");
	      int rowIndex = 0;
	      
	      // 출력할 날짜 또는 시간 값을 지정할 출력 형식
	      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	      // 데이터 포맷터
	      DataFormatter dataFormatter = new DataFormatter();
	      // 숫자형식 대신 문자열로 저장할 셀 스타일 생성
	      CellStyle stringStyle = workbook.createCellStyle();

	      for (Row row : rowList) {
	          Row newRow = sheet.createRow(rowIndex++);
	          for (int i = 0; i < row.getLastCellNum(); i++) {
	              Cell oldCell = row.getCell(i);
	              Cell newCell = newRow.createCell(i);
	              
	              // 스타일 복사
	              if (oldCell != null) {
	                  CellStyle oldCellStyle = oldCell.getCellStyle();
	                  CellStyle newCellStyle = workbook.createCellStyle();
	                  newCellStyle.cloneStyleFrom(oldCellStyle);
	                  newCell.setCellStyle(newCellStyle);
	              }
	              
	              if (oldCell == null) { // 빈 셀일 경우
	                  newCell.setCellValue("");
	              } else if (oldCell.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(oldCell)) {
	                  // 엑셀의 날짜 또는 시간 값을 Date 객체로 변환하여 출력 형식에 맞게 문자열로 변환
	                  Date dateValue = oldCell.getDateCellValue();
	                  String stringValue = dateFormat.format(dateValue);
	                  newCell.setCellValue(stringValue);
	              } else if (oldCell.getCellType() == CellType.NUMERIC) {
	            	    if (oldCell.getCellStyle().getDataFormat() == 1) { // 데이터 형식이 일반 숫자형식일 경우
	            	        DecimalFormat decimalFormat = new DecimalFormat("#");
	            	        String stringValue = decimalFormat.format(oldCell.getNumericCellValue());
	            	        newCell.setCellValue(stringValue);
	            	    } else {
	            	        double numericValue = oldCell.getNumericCellValue();
	            	        String stringValue = String.format("%.0f", numericValue);
	            	        newCell.setCellValue(stringValue);
	            	    }
	            	}  else {
	                  // 기타 타입의 셀은 그대로 복사하여 입력
	                  newCell.setCellValue(oldCell.getStringCellValue());
	              }
	          }
	      }
	      
	      for (int i = 0; i < sheet.getRow(0).getLastCellNum(); i++) {
	    	    sheet.autoSizeColumn(i);
	    	}
	      
	      
	      // 엑셀 파일 저장 경로와 이름 지정
	      String filePath = "C:\\Users\\USER\\Desktop\\files\\test.xlsx";
	      
	      try {
	         // 엑셀 파일 생성
	         FileOutputStream outputStream = new FileOutputStream(filePath);
	         workbook.write(outputStream);
	         workbook.close();
	         outputStream.close();
	         System.out.println("새로운 엑셀 파일이 생성되었습니다.");
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		
		
		return null;
	}

}
