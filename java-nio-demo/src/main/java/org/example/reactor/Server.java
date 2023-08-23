package org.example.reactor;

import java.io.IOException;

public class Server {
    public static void main(String[] args) throws IOException {
        Reactor reactor = new Reactor();
        reactor.run();
    }
}
