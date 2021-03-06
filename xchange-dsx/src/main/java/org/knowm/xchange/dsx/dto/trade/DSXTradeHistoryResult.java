package org.knowm.xchange.dsx.dto.trade;

import java.math.BigDecimal;
import java.text.MessageFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Mikhail Wall
 */

public class DSXTradeHistoryResult {

  private final String pair;
  private final Type type;
  private final BigDecimal amount;
  private final BigDecimal rate;
  private final Long orderId;
  private final int isYourOrder;
  private final Long timestamp;
  private BigDecimal commission;
  private String commissionCurrency;

  public DSXTradeHistoryResult(@JsonProperty("pair") String pair, @JsonProperty("type") Type type, @JsonProperty("amount") BigDecimal amount,
      @JsonProperty("rate") BigDecimal rate, @JsonProperty("order_id") Long orderId, @JsonProperty("is_your_order") int isYourOrder,
      @JsonProperty("timestamp") Long timestamp, @JsonProperty("commission") BigDecimal commission, @JsonProperty("commission_currency") String commissionCurrency) {

    this.pair = pair;
    this.type = type;
    this.amount = amount;
    this.rate = rate;
    this.orderId = orderId;
    this.isYourOrder = isYourOrder;
    this.timestamp = timestamp;
    this.commission = commission;
    this.commissionCurrency = commissionCurrency;
  }

  public String getPair() {
    return pair;
  }

  public Type getType() {
    return type;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public BigDecimal getRate() {
    return rate;
  }

  public Long getOrderId() {
    return orderId;
  }

  public boolean isYourOrder() {
    return isYourOrder == 1;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public BigDecimal getCommission() {
    return commission;
  }

  public String getCommissionCurrency() {
    return commissionCurrency;
  }

  @Override
  public String toString() {

    return MessageFormat.format("DSXOwnTransaction[pair=''{0}'', type={1}, amount={2}, rate={3}, orderId={4}, isYourOrder={5}, timestamp={6}, " +
            "commission={7}, commissionCurrency={8}]",
        pair, type, amount, rate, orderId, isYourOrder, timestamp, commission, commissionCurrency);
  }

  public enum Type {
    buy, sell
  }
}
