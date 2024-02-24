package com.bugratasdemir.odev2bugra202.general;

import com.bugratasdemir.odev2bugra202.errormessage.BaseErrorMessage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequiredArgsConstructor
@Getter
@Setter
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class BusinessException extends RuntimeException{

    private final BaseErrorMessage baseErrorMessage;

    public static BusinessExceptionBuilder builder() {
        return new BusinessExceptionBuilder();
    }

    public static class BusinessExceptionBuilder {
        private BaseErrorMessage baseErrorMessage;
        BusinessExceptionBuilder() {
        }
        public BusinessException build() {
            return new BusinessException(this.baseErrorMessage);
        }
        public BusinessExceptionBuilder baseErrorMessage(final BaseErrorMessage baseErrorMessage) {
            this.baseErrorMessage = baseErrorMessage;
            return this;
        }
        public String toString() {
            return "BusinessException.BusinessExceptionBuilder(hataTipi=" + this.baseErrorMessage + ")";
        }
    }
}
