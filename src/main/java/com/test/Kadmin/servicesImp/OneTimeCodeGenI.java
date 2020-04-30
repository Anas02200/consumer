package com.test.Kadmin.servicesImp;

import com.test.Kadmin.services.OneTimeCodeGen;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class OneTimeCodeGenI implements OneTimeCodeGen {
    @Override
    public String generateCode() {
        String code=RandomStringUtils.random(8,"0123456789");
        return code;
    }
}
