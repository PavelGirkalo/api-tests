package ru.testproject.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResourceUtils {

    public String readResourceAsString(String pathToFile) {
        Path path;
        String data;
        try {
            path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                    .getResource(pathToFile)).toURI());

            Stream<String> lines = Files.lines(path);
            data = lines.collect(Collectors.joining("\n"));
            lines.close();
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }

        return data;
    }
}
