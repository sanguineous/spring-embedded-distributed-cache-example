package com.spikes.cache;


import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Date;
import java.util.concurrent.TimeUnit;


class CacheApplicationIT {

    @Test
    public void testDistributedCaching() {
		String currentTime = String.valueOf(new Date().getTime());
		String requestUri = "http://localhost:8080/cachedGreeting?delay=1000&name=" + currentTime;
		String expectedResponse = String.format("Hello, %s!", currentTime);

		when().
            get(requestUri).
    	then().
            statusCode(200).
			assertThat().
				body(equalTo(expectedResponse));

		when().
            get(requestUri).
    	then().
            statusCode(200).
			time(lessThan(1L), TimeUnit.SECONDS)
			.and().assertThat().
				body(equalTo(expectedResponse));

    }
}
