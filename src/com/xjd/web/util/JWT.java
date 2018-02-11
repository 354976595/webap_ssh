package com.xjd.web.util;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.internal.com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/23.
 */
@JwtAnno(name = "dahsdhiashda",Prams = {"p1","p2"})
public class JWT {
    @Override
    public JWT clone() throws CloneNotSupportedException {
        return (JWT) super.clone();
    }

    private static final String SECRET = "XX#$%()(#*!()!KL<><MQLMNQNQJQK sdfkjsdrow32234545fdf>?N<:{LWPW";

    private static final String EXP = "exp";

    private static final String PAYLOAD = "payload";

    public static <T> String sign(T object, long maxAge) {
        try {
            final JWTSigner signer = new JWTSigner(SECRET);
            final Map<String, Object> claims = new HashMap<String, Object>();
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(object);
            claims.put(PAYLOAD, jsonString);
            claims.put(EXP, System.currentTimeMillis() + maxAge);
            return signer.sign(claims);
        } catch (Exception e) {
            return null;
        }
    }  //解密，传入一个加密后的token字符串和解密后的类型

    public static <T> T unsign(String jwt, Class<T> classT) {
        final JWTVerifier verifier = new JWTVerifier(SECRET);
        try {
            final Map<String, Object> claims = verifier.verify(jwt);
            if (claims.containsKey(EXP) && claims.containsKey(PAYLOAD)) {
                long exp = (Long) claims.get(EXP);
                long currentTimeMillis = System.currentTimeMillis();
                if (exp > currentTimeMillis) {
                    String json = (String) claims.get(PAYLOAD);
                    ObjectMapper objectMapper = new ObjectMapper();
                    return objectMapper.readValue(json, classT);
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, CloneNotSupportedException {
        Method method = JWT.class.getMethod("print", null);
        if (method.isAnnotationPresent(Mytarget.class)) {
            System.out.println(method.getAnnotation(Mytarget.class).value());
        }
        Class classZ = Class.forName("com.xjd.web.util.JWT");
        Annotation[] ano = classZ.getAnnotations();
        if (ano.length == 1) {
            JWT jw = (JWT) classZ.newInstance();
            JWT jwclone=  jw.clone();
            System.out.println(jw.getClass().getAnnotation(JwtAnno.class).name()+"\n"+"hashCode:"+jw.hashCode());
            System.out.println(jwclone.getClass().getAnnotation(JwtAnno.class).name()+"\n"+"hashCode:"+jw.hashCode());
        }

        //  JWT jwt= (JWT) classZ.newInstance();


    }

    @Mytarget
    public void print() {
        System.out.println("print com.xjd.web.juintTestPackage");
    }

    @Retention(RetentionPolicy.RUNTIME)
    @interface Mytarget {
        String value() default "author";
    }
}
