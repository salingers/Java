package annotation;
public @interface Test7 {
    String[] args() default {"arg1", "arg2"};
}