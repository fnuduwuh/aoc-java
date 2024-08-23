package day8;

import java.util.ArrayList;
import java.util.List;

public class TinyScreen {
    private final List<Pixel> pixels = new ArrayList<>();
    private final int screenLength;
    private final int screenHeight;

    public TinyScreen(int length, int height) {
        this.screenLength = length;
        this.screenHeight = height;
    }

    public int getNumberOfPixelsTurnedOn() {
        return this.pixels.size();
    }

    public void addRectangle(int length, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                Pixel pixel = new Pixel(i,j);
                this.pixels.add(pixel);
//                if (!this.pixels.contains(pixel)) this.pixels.add(new Pixel(i, j));
            }
        }
    }

    public void rotateRow(int row, int shifts) {
        for (Pixel pixel : this.pixels) {
            if (pixel.y == row) {
                pixel.x = pixel.x + shifts > this.screenLength
                        ? pixel.x + shifts - this.screenLength
                        : pixel.x + shifts;
            }
        }
    }

    public void rotateColumn(int column, int shifts) {
        for (Pixel pixel : this.pixels) {
            if (pixel.x == column) {
                pixel.y = pixel.y + shifts > this.screenHeight
                        ? pixel.y + shifts - this.screenHeight
                        : pixel.y + shifts;
            }
        }
    }
}

class Pixel {
    int y;
    int x;

    public Pixel(int y, int x) {
        this.y = y;
        this.x = x;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else {
            return obj instanceof Pixel
                    && ((Pixel) obj).x == this.x
                    && ((Pixel) obj).y == this.y;
        }
    }
}
