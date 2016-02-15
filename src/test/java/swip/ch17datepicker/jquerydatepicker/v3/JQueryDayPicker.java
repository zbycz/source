package swip.ch17datepicker.jquerydatepicker.v3;

import swip.ch15pageflow.framework.Browser;
import swip.ch15pageflow.framework.Element;

import static swip.ch15pageflow.locators.TagName.TD;
import static swip.ch17datepicker.jquerydatepicker.v3.JQueryById.UI_DATEPICKER_DIV;
import static swip.ch17datepicker.jquerydatepicker.v3.JQueryPredicates.CALENDAR_CLOSED;

public class JQueryDayPicker {

    private Browser browser;

    public JQueryDayPicker(Browser browser) {
        this.browser = browser;
    }

    public void pickDay(int day) {
        browser.untilFound(UI_DATEPICKER_DIV)
            .findElements(TD)
            .filter((Element e) -> Integer.parseInt(e.getText()) == day)  //<7>
            .findFirst()                     //<8>
            .get()                           //<9>
            .click();
        browser.until(CALENDAR_CLOSED);  //<11>
    }
}