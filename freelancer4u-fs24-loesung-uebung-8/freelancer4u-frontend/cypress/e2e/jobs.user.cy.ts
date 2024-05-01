describe("Manage jobs as user", () => {
    before(() => {
    cy.clearAllSessionStorage();
    cy.visit("http://localhost:8080");
    cy.get("#username").type(Cypress.env()["user"].email);
    cy.get("#password").type(Cypress.env()["user"].password);
    cy.contains("button", "Log in").click();
    cy.get("h1").should("contain", "Welcome");
    });
    it("visit jobs page", () => {
    cy.get('a[href="/jobs"]').click();
    cy.location("pathname").should("include", "jobs");
    });
    })