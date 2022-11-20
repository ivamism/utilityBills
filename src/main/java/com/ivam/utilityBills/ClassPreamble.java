package com.ivam.utilityBills;

import java.lang.annotation.Documented;

@Documented
public @interface ClassPreamble {
    String application() default "Utility Billing Application";
    String author() default "@Author: Ivan Mochalov";
}
