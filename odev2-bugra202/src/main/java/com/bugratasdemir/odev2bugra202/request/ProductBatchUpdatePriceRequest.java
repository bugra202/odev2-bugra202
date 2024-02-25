package com.bugratasdemir.odev2bugra202.request;

import java.util.List;

public record ProductBatchUpdatePriceRequest(List<Long> id,Double price) {}
