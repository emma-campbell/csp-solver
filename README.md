# CSP-Solver

Implementation of Constraint Satisfaction Problems as defined by _Artificial Intelligence: A Modern Approach_ by Russel & Norvig (3 ed). Currently features a backtracking algorithm that implements forward checking. Over time, I will implement more algorithms discussed in the text.

## Contents

The following is contained in the `src` directory.

```bash
.
├── Run.java
├── algo
│   └── Backtrack.java
├── csp
│   ├── Assignment.java
│   ├── CSP.java
│   ├── Constraint.java
│   └── Variable.java
└── problems
    └── map
        ├── AustralianMap.java
        ├── NotEquals.java
        └── Region.java
```

The entry point to the program is `Run.java`.

## How to Run

Change directories into `src` using the command

```bash
cd src
```

and then compile the code using the Java compiler.

```bash
javac Run.java
```

Finally, run the program with the following command:

```bash
java Run
```

