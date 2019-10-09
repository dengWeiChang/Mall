package com.dedu.mall.model.mysql;

public class OrderDetailPo {
    private Long id;
    private Long buyerId;
    private Integer num;
    private BigDecimal totalPrice;
    private String title;
    private Integer sourceType;
    private String logisticsName;
    private String logisticsCode;
    private String receiverState;
    private String receiverCity;
    private String receiverDistrict;
    private String receiverAddress;
    private String receiverMobile;
    private String receiverPostcode;
    private String receiverName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    private Integer status;
    private LocalDateTime consignTime;
    private LocalDateTime endTime;
    private LocalDateTime closeTime;
    private LocalDateTime commentTime;
    private LocalDateTime statusCreateTime;
    private LocalDateTime statusUpdateTime;

    private BigDecimal totalPay;
    private Integer payStatus;
    private Integer payType;
    private LocalDateTime payTime;
    private LocalDateTime payClosedTime;
    private LocalDateTime refundTime;
}
