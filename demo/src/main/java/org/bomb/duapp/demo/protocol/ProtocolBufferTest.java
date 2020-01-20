package org.bomb.duapp.demo.protocol;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ProtocolBufferTest {

    public static void main(String[]args) throws IOException {
        PersonMsg.Person.Builder personBuilder = PersonMsg.Person.newBuilder();
        personBuilder.setId(1);
        personBuilder.setName("bomb");
        personBuilder.setSex(1);
        personBuilder.setIdNo("1234");
        personBuilder.setMobile("13477028014");
        PersonMsg.Person bomb = personBuilder.build();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        bomb.writeTo(output);

        byte[] byteArray = output.toByteArray();

        ByteArrayInputStream input = new ByteArrayInputStream(byteArray);
        PersonMsg.Person jack = PersonMsg.Person.parseFrom(input);

        System.out.println("ID : " + jack.getId());
        System.out.println("NAME : " + jack.getName());
        System.out.println("SEX : " + jack.getSex());

    }
}
