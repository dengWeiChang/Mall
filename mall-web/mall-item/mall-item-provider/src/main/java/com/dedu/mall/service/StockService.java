package com.dedu.mall.service;

import java.math.BigDecimal;
import java.util.Map;

public interface StockService {
    void addStockByMapBatch(Map<Long, BigDecimal> stockMap);
}
