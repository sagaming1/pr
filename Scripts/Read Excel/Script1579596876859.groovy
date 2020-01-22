import com.kms.katalon.core.testdata.reader.ExcelFactory

//third parameter means if you want the first row as your header or column name.
//In your case, it should be true.
Object excelFile = ExcelFactory.getExcelDataWithDefaultSheet("D:\\Workspace\\2020\\0120\\user.xlsx","sheet1", true)

println(excelFile.getRowNumbers()) //Get total rows of the test data
//https://docs.katalon.com/javadoc/com/kms/katalon/core/testdata/reader/SheetPOI.html
println(excelFile.internallyGetValue(0, 0))// 第一行第二列
println(excelFile.internallyGetValue(0, 1))// 第一行第三列
//create a loop
//for (int index = 0; index < excelFile.size(); index++)
//{
//	println excelFile.getValue("user", index) + " " + excelFile.getValue("password", index)
//}