package ricky.oknets;

import ricky.oknet.cache.CacheMode;
import ricky.oknet.modeinterface.NetRequest;
import ricky.oknet.modeinterface.annotation.CACHE;
import ricky.oknet.modeinterface.annotation.GET;
import ricky.oknet.modeinterface.annotation.PARAMS;
import ricky.oknets.response.CityResponse;
import ricky.oknets.response.RequestInfo;

public interface HttpApi {

    @GET("http://192.168.1.70/api/common/cityList")//?productLine=5&os=android
    NetRequest<CityResponse.DataBean> cityList(@PARAMS("productLine") int productLine, @PARAMS("os") String os);

    @CACHE(CacheMode.FIRST_CACHE_THEN_REQUEST)
    @GET("method")
    NetRequest<RequestInfo> method();


}
