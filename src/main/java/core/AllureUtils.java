package core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.events.TestCaseEvent;
import ru.yandex.qatools.allure.model.Parameter;
import ru.yandex.qatools.allure.model.ParameterKind;
import ru.yandex.qatools.allure.model.TestCaseResult;

/**
 * Created by Dell-SSD on 30.07.2017.
 */

    public class AllureUtils {

        private static Logger logger = LoggerFactory.getLogger(core.AllureUtils.class);

        private static Parameter parameter(String name, String value) {
            Parameter param = new Parameter();
            param.setName(name);
            param.setValue(value);
            param.setKind(ParameterKind.ENVIRONMENT_VARIABLE);
            return param;
        }

        public static void fireAllureParameter(final String name, final String value) {
            Allure.LIFECYCLE.fire(new TestCaseEvent() {
                @Override
                public void process(TestCaseResult testCaseResult) {
                    testCaseResult.getParameters().add(parameter(name, value));
                    logger.info(name+":"+value);

                }
            });
        }
}
