package fr.lacombe.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.Collections.emptyList;

class History {

    private final List<OperationStatement> statements;

    private History(final List<OperationStatement> statements) {
        this.statements = statements;
    }

    static History empty() {
        return new History(emptyList());
    }

    static History of(final List<OperationStatement> statements) {
        return new History(statements);
    }

    History put(final OperationStatement statement) {
        final List<OperationStatement> statements = new ArrayList<>(this.statements);
        statements.add(statement);

        return new History(statements);
    }

    Optional<OperationStatement> lastStatement() {
        if (statements.isEmpty())
            return Optional.empty();

        return Optional.of(statements.get(statements.size() - 1));
    }

    Amount currentBalance() {
        return lastStatement()
                .map(OperationStatement::getBalance)
                .orElseGet(() -> Amount.of(0L));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final History history = (History) o;
        return Objects.equals(statements, history.statements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statements);
    }
}
