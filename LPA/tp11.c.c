#include <stdio.h>
#include <stdlib.h>
#include <GL/glut.h>
#include <time.h>

int linha = 0;

typedef struct tipo_seg {
    float y;
    float x;
} tipo_seg;

int ccw(tipo_seg a, tipo_seg b, tipo_seg c) {
    return (c.y - a.y) * (b.x - a.x) > (b.y - a.y) * (c.x - a.x);
}

int intersect(tipo_seg a, tipo_seg b, tipo_seg c, tipo_seg d) {
    return ccw(a, c, d) != ccw(b, c, d) && ccw(a, b, c) != ccw(a, b, d);
}

void display(void) {
    glClear(GL_COLOR_BUFFER_BIT);
    glColor3f(0.0, 1.0, 0.0);
    glBegin(GL_LINES);

    tipo_seg *segmento = (tipo_seg*)malloc(sizeof(tipo_seg) * 2 * linha);
    int c = 0;

    srand(time(NULL));

    for(int i = 0; i < linha; i++) {
        tipo_seg a = {(float)(rand() % 300), (float)(rand() % 300)};
        tipo_seg b = {(float)(rand() % 300), (float)(rand() % 300)};

        int cruza = 0;
        for(int j = 0; j < c; j += 2) {
            if(intersect(a, b, segmento[j], segmento[j + 1])) {
                cruza = 1;
                break;
            }
        }

        if (cruza == 0) {
            glVertex2f(a.x, a.y);
            glVertex2f(b.x, b.y);
            segmento[c++] = a;
            segmento[c++] = b;
        }
    }

    free(segmento);
    glEnd();
    glFlush();
}

int main(int argc, char **argv) {
    linha = atoi(argv[3]);

    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB | GLUT_DEPTH);

    glutInitWindowSize(atoi(argv[1]), atoi(argv[2]));
    glutCreateWindow("Segmentos Aleatorios");
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    glOrtho(0.0, 300.0, 0.0, 300.0, -1.0, 1.0);

    glClearColor(1.0, 1.0, 1.0, 1.0);

    glutDisplayFunc(display);
    glutMainLoop();

    return 0;
}
