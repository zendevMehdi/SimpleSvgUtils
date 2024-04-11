# SimpleSvgUtils

This library allow developers to load svg files from disk and change the swing components icons.

## Authors

- [@Mehdi Lavasani](https://github.com/zendevMehdi)


## Features

- Load svg file from disk and change components icon
- Only supports JButton, JLabel and JMenuItem components
- Set svg file width and height
- Load items from project resources

## Installation

You can get jar from release section or create new project and add src folder to the project.


## Usage/Examples

I created a label and add it to the window, then i load the svg file from D:\ drive and set the label icon.

```java
package org.zendev.lib.svg;

import org.apache.batik.transcoder.TranscoderException;

import javax.swing.*;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws TranscoderException, IOException {
        var label = new JLabel();
        var frame = new JFrame("Test application");

        frame.add(label);
        SimpleSvgUtils.setComponentIcon(label, "D:\\tmp\\cat.svg", 50F, 50F);

        frame.setVisible(true);
    }
}
```

## Screenshots

![screenshots/cat.png](https://github.com/zendevMehdi/SimpleSvgUtils/blob/afbf88f4d5e9667c03b42c3cea0aae3a462fe292/screenshots/cat.png)
