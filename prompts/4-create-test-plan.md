You are in the DESIGN PHASE for this project. Create a TDD test plan grounded in the narrative domain description and CRC cards.

Inputs:
- CRC_FILE: design/crc.md
- PLAN_FILE: plan.md

Task:
- Read the design for this iteration in plan.md.
- Read CRC_FILE to align behaviors with object responsibilities and collaborations.
- Find and read existing unit tests in this project to see what responsibilities are already implemented.
- In plan.md, write a concise list of tests to implement next, each test anchored to observable signals described in the narrative and to specific responsibilities in CRC.

Format to preserve in PLAN_FILE:
- Keep existing headings and structure. Add a section (if not already there) "Tests to Implement (TDD)" and populate it with a checklist.
- One test per bullet. Use short, descriptive names in the problem domain language.
- Under each test name, optionally add one or a few sub-bullets stating the observable cue you will assert.

Heuristics for deriving tests:
- Each test should come from one of:
  - A decisive rule/end condition in the scenario description, unless a test for that already exists.
  - A responsibility in CRC cards, unless a test for that already exists.
- Ensure every test references an observable output, not hidden internals.
- Keep the first pass lean (5–9 tests). More can be added in subsequent iterations.

Output:
- Return the fully updated PLAN_FILE content only. No commentary outside the file content.

Checklist before returning:
- [ ] Tests are phrased in domain language and tied to observable cues
- [ ] Each test maps to a responsibility in CRC or a rule in the scenario description
- [ ] Formatting and existing sections of PLAN_FILE are preserved
