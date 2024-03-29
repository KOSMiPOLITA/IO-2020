package put.io.testing.mocks;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.*;
import org.mockito.*;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;

import java.util.Collections;

public class ExpenseRepositoryTest {
    private ExpenseRepository rep;

    @org.junit.jupiter.api.BeforeEach
    private void setUp() {
        MyDatabase db = new MyDatabase(); }

    @org.junit.jupiter.api.Test
    void TestloadExpenses() {
        MyDatabase mockObject = mock(MyDatabase.class);
        when(mockObject.queryAll()).thenReturn(Collections.emptyList());
        rep = new ExpenseRepository(mockObject);
        rep.loadExpenses();
        assertEquals(rep.getExpenses().stream().count(), 0);
        InOrder inOrder = inOrder(mockObject);
        inOrder.verify(mockObject).connect();
        inOrder.verify(mockObject).queryAll();
        inOrder.verify(mockObject).close(); }

    @org.junit.jupiter.api.Test
    void TestSaveExpenses() {
        MyDatabase mockObject = mock(MyDatabase.class);
        when(mockObject.queryAll()).thenReturn(Collections.emptyList());
        Expense exp = new Expense();
        rep = new ExpenseRepository(mockObject);
        rep.loadExpenses();
        rep.addExpense(exp);
        rep.addExpense(exp);
        rep.addExpense(exp);
        rep.addExpense(exp);
        rep.addExpense(exp);
        rep.saveExpenses();
        verify(mockObject, times(5)).persist(any(Expense.class)); }
}
