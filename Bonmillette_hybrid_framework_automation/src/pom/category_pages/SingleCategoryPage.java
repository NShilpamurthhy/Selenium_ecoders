package pom.category_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import generic.Verification;

public class SingleCategoryPage extends Verification {

    // **Header Elements**
    @FindBy(xpath = "//header")
    private WebElement header;

    @FindBy(xpath = "//img[@alt='Logo']")
    private WebElement headerLogo;

    @FindBy(xpath = "//nav//a[@href='/home']")
    private WebElement homeLink;

    @FindBy(xpath = "//nav//a[@href='/shop']")
    private WebElement shopLink;

    @FindBy(xpath = "//nav//a[@href='/our-story']")
    private WebElement ourStoryLink;

    @FindBy(xpath = "//nav//a[@href='/all-blogs']")
    private WebElement blogLink;

    @FindBy(xpath = "//nav//a[@href='/contact-us']")
    private WebElement contactUsLink;

    @FindBy(xpath = "//button[contains(@class, 'text-black font-bold text-lg')]")
    private WebElement myAccountButton;

    @FindBy(xpath = "(//*[name()='svg'])[1]")
    private WebElement searchIcon;

    @FindBy(xpath = "(//*[name()='svg'])[2]")
    private WebElement cartIcon;

    // **Category Details Elements**
    @FindBy(xpath = "//h2[contains(@class, 'text-3xl font-bold')]")
    private WebElement categoryTitle;

    @FindBy(xpath = "//a[@href='/all-categories']")
    private WebElement allCategoriesLink;

    @FindBy(xpath = "//h3[contains(@class, 'text-lg font-semibold')]")
    private WebElement categoryDetailsTitle;

    @FindBy(xpath = "//dt[contains(text(),'Category Name')]")
    private WebElement categoryNameLabel;

    @FindBy(xpath = "//input[contains(@class, 'border px-2 py-1 rounded')]")
    private WebElement categoryNameInput;

    @FindBy(xpath = "//button[contains(@class, 'bg-blue-500 text-white')]")
    private WebElement editSaveButton;

    @FindBy(xpath = "//dt[contains(text(),'Created At')]")
    private WebElement createdAtLabel;

    @FindBy(xpath = "//dd[contains(@class, 'text-gray-700')]")
    private WebElement createdAtValue;

    // **Footer Elements**
    @FindBy(xpath = "//footer")
    private WebElement footer;

    @FindBy(xpath = "//img[@alt='company logo']")
    private WebElement footerLogo;

    @FindBy(xpath = "//a[contains(@href, 'instagram.com')]")
    private WebElement instagramLink;

    @FindBy(xpath = "//a[contains(@href, 'linkedin.com')]")
    private WebElement linkedinLink;

    @FindBy(xpath = "//a[contains(@href, 'facebook.com')]")
    private WebElement facebookLink;

    @FindBy(xpath = "//a[contains(@href, 'twitter.com')]")
    private WebElement twitterLink;

    @FindBy(xpath = "//a[@href='/privacy-policy']")
    private WebElement privacyPolicyLink;

    @FindBy(xpath = "//a[@href='/terms-and-conditions']")
    private WebElement termsAndConditionsLink;

    @FindBy(xpath = "//a[@href='/return-policy']")
    private WebElement returnPolicyLink;

    // **Constructor for Initialization**
    public SingleCategoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // **Header Methods**
    public boolean isHeaderDisplayed() {
        return header.isDisplayed();
    }

    public void clickOnLogo() {
        headerLogo.click();
    }

    public void clickHomeLink() {
        homeLink.click();
    }

    public void clickShopLink() {
        shopLink.click();
    }

    public void clickOurStoryLink() {
        ourStoryLink.click();
    }

    public void clickBlogLink() {
        blogLink.click();
    }

    public void clickContactUsLink() {
        contactUsLink.click();
    }

    public void clickMyAccountButton() {
        myAccountButton.click();
    }

    public void clickSearchIcon() {
        searchIcon.click();
    }

    public void clickCartIcon() {
        cartIcon.click();
    }

    // **Category Page Methods**
    public String getCategoryTitle() {
        return categoryTitle.getText();
    }

    public boolean verifyCategoryTitle(SoftAssert softAssert, String expectedTitle) {
        return verifyTextPresent(categoryTitle.getText(), softAssert);
    }

    public void clickAllCategoriesLink() {
        allCategoriesLink.click();
    }

    public String getCategoryDetailsTitle() {
        return categoryDetailsTitle.getText();
    }

    public boolean isCategoryNameDisplayed() {
        return categoryNameLabel.isDisplayed();
    }

    public void enterCategoryName(String categoryName) {
        categoryNameInput.clear();
        categoryNameInput.sendKeys(categoryName);
    }

    public void clickEditSaveButton() {
        editSaveButton.click();
    }

    public String getCreatedAtDate() {
        return createdAtValue.getText();
    }

    // **Footer Methods**
    public boolean isFooterDisplayed() {
        return footer.isDisplayed();
    }

    public void clickInstagramLink() {
        instagramLink.click();
    }

    public void clickFacebookLink() {
        facebookLink.click();
    }

    public void clickLinkedInLink() {
        linkedinLink.click();
    }

    public void clickTwitterLink() {
        twitterLink.click();
    }

    public void clickPrivacyPolicyLink() {
        privacyPolicyLink.click();
    }

    public void clickTermsAndConditionsLink() {
        termsAndConditionsLink.click();
    }

    public void clickReturnPolicyLink() {
        returnPolicyLink.click();
    }
}

