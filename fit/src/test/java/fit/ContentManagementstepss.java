package fit;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContentManagementstepss {

    private Admin app1;
    public ContentManagementstepss() {
        app1 = new Admin();
    }



    @Test
    public void testSubmitTipSuccess() {
        app1.submitTip("This is a tip.");
        assertTrue(app1.getTips().contains("This is a tip."));
    }

    @Test
    public void testSubmitEmptyTip() {
        app1.submitTip("");
        assertFalse(app1.getTips().contains(""));
    }

    @Test
    public void testReviewTip() {
        app1.submitTip("Tip 1");
        assertTrue(app1.getTips().contains("Tip 1"));
    }

    @Test
    public void testApproveTip() {
        app1.submitTip("Tip 1");
        app1.approveTip("Tip 1");
        assertTrue(app1.getTips().contains("Tip 1"));
    }

    @Test
    public void testRejectTip() {
        app1.submitTip("Tip 1");
        app1.rejectTip("Tip 1");
        assertFalse(app1.getTips().contains("Tip 1"));
    }

    @Test
    public void testRejectNonexistentTip() {
        app1.rejectTip("Nonexistent Tip");
        assertFalse(app1.getTips().contains("Nonexistent Tip"));
    }
}
