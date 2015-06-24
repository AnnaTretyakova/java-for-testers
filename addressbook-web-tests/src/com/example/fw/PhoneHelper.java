package com.example.fw;

import com.example.utils.SortedListOf;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PhoneHelper extends WebDriverHelperBase {

    public PhoneHelper(ApplicationManager manager) {
        super(manager);
    }

    public SortedListOf<String> getContactsInfo() {
        manager.navigateTo().printPhones();
        SortedListOf<String> contactInfoList = new SortedListOf<String>();
        List<WebElement> cells = manager.getDriver().findElements(By.xpath("//td[@valign = \"top\"]"));
        for (WebElement cell: cells){
            String contactInfo;
            String namesInCell = cell.findElement(By.xpath("b")).getText();
            String textInCell = cell.getText();
            String phone;
            if (textInCell.contains("H:")) {
                phone = getPhone(textInCell, "H");
            }else if(textInCell.contains("M:")){
                phone = getPhone(textInCell, "M");
            }else if(textInCell.contains("W:")) {
                phone = getPhone(textInCell, "W");
            }else{
                phone = "";
            }
            contactInfo = namesInCell.replace(" ","") + phone;
            contactInfoList.add(contactInfo);
        }
        return contactInfoList;
    }

    private String getPhone(String textInCell, String phoneType) {
        String phone;
        phone = textInCell.substring(textInCell.indexOf(phoneType) + 3, textInCell.length());
        phone = phone.substring(0, phone.indexOf("\n"));
        return phone;
    }
}
