package com.appleframework.auto.calculate.fence.consumer;

import javax.annotation.Resource;

import com.appleframework.auto.calculate.fence.service.FenceCalculateService;
import com.appleframework.bean.location.LocationProto;
import com.appleframework.jms.kafka.consumer.BytesMessageConsumer;
import com.google.protobuf.InvalidProtocolBufferException;

public class LocationConsumer extends BytesMessageConsumer {
	
	@Resource
	private FenceCalculateService fenceCalculateService;

	@Override
	public void processMessage(byte[] message) {
		
		try {
			LocationProto.Model location = LocationProto.Model.parseFrom(message);
			fenceCalculateService.calculate(location);
		} catch (InvalidProtocolBufferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
}