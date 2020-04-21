package com.learning.system.Attribute;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Created by karim on 4/16/20.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface SystemAttribute extends Serializable{
}
