package com.telran.qa20.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Board extends HelperBase{

    public Board(WebDriver wd) {
        super(wd);

    }

    public  void confirmBoardCreation(){
        click(By.cssSelector("[data-test-id=header-create-board-submit-button]"));
    }

    public void typeBoardName(String boardName) {
        type(By.cssSelector("[data-test-id=header-create-board-title-input]"), boardName);

    }

    public void selectCreateBoardFromDropDown() {
        click(By.cssSelector("[data-test-id=header-create-board-button]"));
    }

    public int getPersonalBoardsCount() {
        return  wd.findElements(By.xpath("//span[@class='icon-lg icon-member']/../../..//li")).size()-1;
    }

    public void initBoardDeletion() {
        openMenu();
        clickMoreButtonInTheMenu();
        clickCloseBoardButton();
        confirmCloseButton();
    }

    public void confirmCloseButton() {
        click(By.cssSelector(".js-confirm.full.negate"));
    }

    public void clickCloseBoardButton() {
        click(By.cssSelector(".board-menu-navigation-item-link.js-close-board"));
    }

    public void clickMoreButtonInTheMenu() {
        click(By.cssSelector(".board-menu-navigation-item-link.js-open-more"));
    }

    public void openMenu() {
        if(!isBoardMenuOpened()){
            click(By.cssSelector(".board-header-btn-text.u-text-underline"));
        }
    }

    public void confirmBoardDeletion() {
        click(By.cssSelector(".js-delete"));
    }

    public void confirmFinishBoardDeletion() {
        click(By.cssSelector(".js-confirm.full"));
    }

    public boolean isBoardMenuOpened() {
        return isElementPresent(By.cssSelector(".board-header-btn-text.u-text-underline"));
    }

    public void openFirstPrivateBoard() {
        WebElement privateBoardsList = wd.findElement(By.xpath("//span[@class='icon-lg icon-member']/../../..//ul"));
        String boardNameForDelete = privateBoardsList.findElement(By.xpath(".//li")).getText();
        System.out.println(boardNameForDelete);
        privateBoardsList.findElement(By.xpath(".//li")).click();
    }
    public int getPrivateBoardsCount() {
        return wd.findElements(By.xpath("//span[@class='icon-lg icon-member']/../../..//li")).size()-1;
    }

}
