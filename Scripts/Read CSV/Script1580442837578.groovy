import com.kms.katalon.core.testdata.CSVData
import com.kms.katalon.core.testdata.reader.CSVSeparator


CSVData csvData = new CSVData("D:\\Workspace\\2020\\0120\\demo.csv", true, CSVSeparator.COMMA)

println(csvData.getAllData())
//to access or to get the .csv file values refer to some commonly used commands
//csvData.allData or csvData.getAllData()
//csvData.getValue(‘columnname’, int rowNumber)
//csvData.rowNumbers //this is to get all the used rows or total number of rows
//csvData.columnNumbers
//csvData.columnNames

