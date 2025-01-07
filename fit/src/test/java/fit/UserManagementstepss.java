package fit;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class UserManagementstepss {
 
    private Admin app1;
    public UserManagementstepss() {
        app1 = new Admin(); // تهيئة MyApplication
    }


    @Test
    public void testAdminLoginSuccess() {
        assertTrue(app1.loginAsAdmin("admin1", "adminPass"));
    }

    @Test
    public void testAdminLoginFailure() {
        assertFalse(app1.loginAsAdmin("admin1", "wrongPass"));
    }

    @Test
    public void testSubmitTipSuccess() {
        app1.submitTip("This is a tip.");
        assertEquals(1, app1.getTips().size());
    }

    @Test
    public void testSubmitEmptyTip() {
        app1.submitTip("");
        assertEquals(0, app1.getTips().size());
    }

    @Test
    public void testReviewTip() {
        app1.submitTip("Tip 1");
        assertEquals("Tip 1", app1.getTips().get(0));
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
        assertEquals(0, app1.getTips().size());
    }

   
    @Test
    public void testAddInstructor() {
        // محاكاة المدخلات باستخدام Scanner
        Scanner scanner = new Scanner(System.in);
        
        // تمرير المدخلات عبر الـ Scanner (ملاحظة: المدخلات هنا ستكون من المستخدم)
        app1.addInstructor(scanner);  

        // التحقق من أن المعلم تم إضافته إلى instructors
        // نحاول الوصول إلى أول مفتاح موجود في Map
        assertFalse(Admin.instructors.isEmpty()); // التأكد من أن الـ Map ليس فارغًا

        // الحصول على أول معلم تم إضافته (المفتاح الأول)
        String firstInstructor = Admin.instructors.keySet().iterator().next(); 

        // التأكد من أن المفتاح الموجود في Map هو نفس المدخلات التي تم إدخالها عبر الـ Scanner
        assertNotNull(firstInstructor);  // التأكد من أن المفتاح ليس فارغًا
        System.out.println("Instructor added: " + firstInstructor);

        // التحقق من أن كلمة المرور المدخلة تم تخزينها في الـ Map بشكل صحيح
        String storedPassword = Admin.instructors.get(firstInstructor); 
        assertNotNull(storedPassword);  // التأكد من أنه تم تخزين كلمة المرور
        System.out.println("Instructor password: " + storedPassword);
    }

    @Test
    public void testUpdateInstructor() {
        // محاكاة المدخلات باستخدام Scanner
        Scanner scanner = new Scanner(System.in);

        // إضافة المعلم أولاً عبر الـ Scanner
        app1.addInstructor(scanner);

        // التحقق من أن المعلم تم إضافته (التأكد من أن الـ Map يحتوي على عنصر واحد على الأقل)
        assertFalse(Admin.instructors.isEmpty());

        // الحصول على أول معلم تم إضافته (المفتاح الأول)
        String firstInstructor = Admin.instructors.keySet().iterator().next();

        // محاكاة مدخلات كلمة المرور الجديدة عبر الـ Scanner
        System.out.print("Enter new password for " + firstInstructor + ": ");
        String newPassword = scanner.nextLine(); // قراءة كلمة المرور الجديدة من المستخدم

        // تحديث كلمة مرور المعلم
        app1.updateInstructor(scanner);

        // التحقق من أن كلمة المرور تم تحديثها في الـ Map
        String storedPassword = Admin.instructors.get(firstInstructor);
        assertNotNull(storedPassword);  // التأكد من أنه تم تخزين كلمة المرور
        assertEquals(newPassword, storedPassword);  // التحقق من أن الكلمة هي نفس المدخلة من قبل المستخدم

        // التأكد من أن القيم المخزنة في Map هي نفسها التي تم إدخالها عبر الـ Scanner
        System.out.println("Instructor updated: " + firstInstructor + " with new password: " + storedPassword);
    }


    @Test
    public void testAddClient() {
        // محاكاة المدخلات باستخدام Scanner
        Scanner scanner = new Scanner(System.in);

        // إضافة العميل عبر الـ Scanner
        app1.addClient(scanner);

        // التحقق من أن العميل تم إضافته (التأكد من أن الـ Map يحتوي على عنصر واحد على الأقل)
        assertFalse(app1.accounts.isEmpty());

        // الحصول على أول عميل تم إضافته (المفتاح الأول)
        String firstClient = app1.accounts.keySet().iterator().next();

        // التأكد من أن العميل تم إضافته إلى الـ Map
        assertNotNull(firstClient);  // التأكد من أن المفتاح ليس فارغًا
        System.out.println("Client added: " + firstClient);
    }



    @Test
    public void testUpdateClient() {
        // محاكاة المدخلات باستخدام Scanner
        Scanner scanner = new Scanner(System.in);

        // إضافة العميل أولاً عبر الـ Scanner
        app1.addClient(scanner);

        // التحقق من أن العميل تم إضافته (التأكد من أن الـ Map يحتوي على عنصر واحد على الأقل)
        assertFalse(app1.accounts.isEmpty());

        // الحصول على أول عميل تم إضافته (المفتاح الأول)
        String firstClient = app1.accounts.keySet().iterator().next();

        // محاكاة مدخلات كلمة المرور الجديدة عبر الـ Scanner
        System.out.print("Enter new password for " + firstClient + ": ");
        String newPassword = scanner.nextLine(); // قراءة كلمة المرور الجديدة من المستخدم

        // تحديث كلمة مرور العميل
        app1.updateClient(scanner);

        // التحقق من أن كلمة المرور تم تحديثها في الـ Map
        String storedPassword = app1.accounts.get(firstClient);
        assertNotNull(storedPassword);  // التأكد من أنه تم تخزين كلمة المرور
        assertEquals(newPassword, storedPassword);  // التحقق من أن الكلمة هي نفس المدخلة من قبل المستخدم

        // التأكد من أن القيم المخزنة في Map هي نفسها التي تم إدخالها عبر الـ Scanner
        System.out.println("Client updated: " + firstClient + " with new password: " + storedPassword);
    }


    @Test
    public void testDeactivateClient() {
        // محاكاة المدخلات باستخدام Scanner
        Scanner scanner = new Scanner(System.in);

        // إضافة العميل أولاً عبر الـ Scanner
        app1.addClient(scanner);

        // التحقق من أن العميل تم إضافته (التأكد من أن الـ Map يحتوي على عنصر واحد على الأقل)
        assertFalse(app1.accounts.isEmpty());

        // الحصول على أول عميل تم إضافته (المفتاح الأول)
        String firstClient = app1.accounts.keySet().iterator().next();

        // إلغاء تفعيل العميل
        app1.deactivateClient(scanner);

       
        System.out.println("Client deactivated: " + firstClient);
    }

}
