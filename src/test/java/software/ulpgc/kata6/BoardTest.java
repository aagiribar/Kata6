package software.ulpgc.kata6;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static software.ulpgc.kata6.BoardTest.Cases.*;

public class BoardTest {
    @Test
    void should_return_empty_1x1_board_when_an_empty_1x1_board_is_passed() {
        Board board = new Board(".");
        assertThat(board.next().toString()).isEqualTo(".");
    }

    @Test
    void should_return_empty_1x1_board_when_a_full_1x1_board_is_passed() {
        Board board = new Board("X");
        assertThat(board.next().toString()).isEqualTo(".");
    }

    @Test
    void should_return_empty_2x2_board_when_an_empty_2x2_board_is_passed() {
        Board board = new Board(empty_2x2_board);
        assertThat(board.next().toString()).isEqualTo(empty_2x2_board);
    }

    @Test
    void should_return_empty_2x2_board_when_a_2x2_board_with_an_alive_cell_is_passed() {
        Board board = new Board(board_2x2_with_an_alive_cell);
        assertThat(board.next().toString()).isEqualTo(empty_2x2_board);
    }

    @Test
    void should_return_empty_2x2_board_when_a_2x2_board_with_2_alive_cells_is_passed() {
        Board board = new Board(board_2x2_with_2_alive_cells);
        assertThat(board.next().toString()).isEqualTo(empty_2x2_board);
    }

    @Test
    void should_return_full_2x2_board_when_a_2x2_board_with_3_alive_cells_is_passed() {
        Board board = new Board(board_2x2_with_3_alive_cells);
        assertThat(board.next().toString()).isEqualTo(board_2x2_with_4_alive_cells);
    }

    @Test
    void should_return_full_2x2_board_when_a_2x2_board_with_4_alive_cells_is_passed() {
        Board board = new Board(board_2x2_with_4_alive_cells);
        assertThat(board.next().toString()).isEqualTo(board_2x2_with_4_alive_cells);
    }

    @Test
    void should_return_empty_3x3_board_when_an_empty_3x3_board_passed() {
        Board board = new Board(board_3x3_empty);
        assertThat(board.next().toString()).isEqualTo(board_3x3_empty);
    }

    @Test
    void should_return_empty_3x3_board_when_a_3x3_board_with_an_alive_cell_is_passed() {
        Board board = new Board(board_3x3_with_an_alive_cell);
        assertThat(board.next().toString()).isEqualTo(board_3x3_empty);
    }

    @Test
    void should_return_board_3x3_with_2_alive_cells_in_the_first_and_second_row_when_board_3x3_with_3_alive_cells_in_the_top_row_is_passed() {
        Board board = new Board(board_3x3_with_3_alive_cells_in_the_top_row);
        assertThat(board.next().toString()).isEqualTo(board_3x3_with_2_alive_cells_in_the_first_and_second_row);
    }

    @Test
    void should_return_board_3x3_with_3_alive_cells_in_the_top_row_when_a_board_3x3_with_T_shape_is_passed() {
        Board board = new Board(board_3x3_with_T_shape);
        assertThat(board.next().toString()).isEqualTo(board_3x3_with_3_alive_cells_in_the_top_row);
    }

    @Test
    void should_return_board_3x3_with_alive_cells_at_corners_when_a_board_3x3_with_all_alive_cells_is_passed() {
        Board board = new Board(board_3x3_with_all_alive_cells);
        assertThat(board.next().toString()).isEqualTo(board_3x3_with_alive_cells_at_corners);
    }

    @Test
    void should_return_same_board_when_board_3x3_with_diamond_shape_is_passed() {
        Board board = new Board(board_3x3_with_diamond_shape);
        assertThat(board.next().toString()).isEqualTo(board_3x3_with_diamond_shape);
    }

    public static class Cases {
        public static final String empty_2x2_board = """
                ..
                ..
                """.trim();
        public static final String board_2x2_with_an_alive_cell = """
                .X
                ..
                """.trim();
        public static final String board_2x2_with_2_alive_cells = """
                XX
                ..
                """.trim();
        public static final String board_2x2_with_3_alive_cells = """
                XX
                .X
                """.trim();
        public static final String board_2x2_with_4_alive_cells = """
                XX
                XX
                """.trim();
        public static final String board_3x3_empty = """
                ...
                ...
                ...
                """.trim();
        public static final String board_3x3_with_an_alive_cell = """
                X..
                ...
                ...
                """.trim();
        public static final String board_3x3_with_3_alive_cells_in_the_top_row = """
                XXX
                ...
                ...
                """.trim();
        public static final String board_3x3_with_2_alive_cells_in_the_first_and_second_row = """
                .X.
                .X.
                ...
                """.trim();
        public static final String board_3x3_with_T_shape = """
                XXX
                .X.
                .X.
                """.trim();
        public static final String board_3x3_with_all_alive_cells = """
                XXX
                XXX
                XXX
                """.trim();
        public static final String board_3x3_with_alive_cells_at_corners = """
                X.X
                ...
                X.X
                """.trim();
        public static final String board_3x3_with_diamond_shape = """
                .X.
                X.X
                .X.
                """.trim();
    }
}
