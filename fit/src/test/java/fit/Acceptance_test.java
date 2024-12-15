package fit;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features",  // تحديد مسار مجلد أو ملفات الـ .feature
        plugin = {"pretty", "html:target/cucumber-report.html"},  // تحديد طرق عرض نتائج الاختبارات
        monochrome = true,  // لتنسيق الإخراج بطريقة قابلة للقراءة
        snippets = SnippetType.CAMELCASE,  // استخدام camelCase للأوامر المفقودة
        glue = "fit"  // تحديد الحزمة التي تحتوي على الخطوات Step Definitions
)
public class Acceptance_test {
}

