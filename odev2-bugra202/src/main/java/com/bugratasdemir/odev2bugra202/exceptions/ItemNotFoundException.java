package com.bugratasdemir.odev2bugra202.exceptions;

import com.bugratasdemir.odev2bugra202.errormessage.BaseErrorMessage;
import com.bugratasdemir.odev2bugra202.general.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends BusinessException {
    public ItemNotFoundException(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}
