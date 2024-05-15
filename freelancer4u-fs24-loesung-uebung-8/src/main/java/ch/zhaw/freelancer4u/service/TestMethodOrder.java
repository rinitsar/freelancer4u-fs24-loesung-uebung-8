package ch.zhaw.freelancer4u.service;

import MethodOrderer.OrderAnnotation;

public @interface TestMethodOrder {

    Class<OrderAnnotation> value();

}
