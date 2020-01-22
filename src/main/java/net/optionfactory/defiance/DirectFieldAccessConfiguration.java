package net.optionfactory.defiance;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.validation.Validator;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;

@Configuration
public class DirectFieldAccessConfiguration extends DelegatingWebMvcConfiguration {
    @Override
    protected ConfigurableWebBindingInitializer getConfigurableWebBindingInitializer(FormattingConversionService mvcConversionService, Validator mvcValidator) {
        ConfigurableWebBindingInitializer initializer = new ConfigurableWebBindingInitializer();
        initializer.setDirectFieldAccess(true);
        initializer.setConversionService(mvcConversionService);
        initializer.setValidator(mvcValidator);
        initializer.setMessageCodesResolver(getMessageCodesResolver());
        return initializer;
    }
}
