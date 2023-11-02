// ***********************************************
// This example namespace declaration will help
// with Intellisense and code completion in your
// IDE or Text Editor.
// ***********************************************
// declare namespace Cypress {
//   interface Chainable<Subject = any> {
//     customCommand(param: any): typeof customCommand;
//   }
// }
//
// function customCommand(param: any): void {
//   console.warn(param);
// }
//
// NOTE: You can use it like so:
// Cypress.Commands.add('customCommand', customCommand);
//
// ***********************************************
// This example commands.js shows you how to
// create various custom commands and overwrite
// existing commands.
//
// For more comprehensive examples of custom
// commands please read more here:
// https://on.cypress.io/custom-commands
// ***********************************************
//
//
// -- This is a parent command --
// Cypress.Commands.add("login", (email, password) => { ... })
//
//
// -- This is a child command --
// Cypress.Commands.add("drag", { prevSubject: 'element'}, (subject, options) => { ... })
//
//
// -- This is a dual command --
// Cypress.Commands.add("dismiss", { prevSubject: 'optional'}, (subject, options) => { ... })
//
//
// -- This will overwrite an existing command --
// Cypress.Commands.overwrite("visit", (originalFn, url, options) => { ... })

import { Interception } from "cypress/types/net-stubbing";
import auth from "../fixtures/user.json";


let LOCAL_STORAGE_MEMORY: { [key: string]: string } = {};

Cypress.Commands.addAll({
  saveLocalStorage: () =>
    Object.keys(localStorage).forEach(
      (key: string) => (LOCAL_STORAGE_MEMORY[key] = localStorage[key])
    ),

  restoreLocalStorage: () =>
    Object.keys(LOCAL_STORAGE_MEMORY).forEach((key: string) =>
      localStorage.setItem(key, LOCAL_STORAGE_MEMORY[key])
    ),

  fillForm: (name:string, email: string) => {
    cy.getElement("nameForm").click()
    cy.getElement("nameForm").type(name)
    cy.getElement("emailForm").click()
    cy.getElement("emailForm").type(email)
  },

  getElement: (dataCY: string, shouldBeVisible: boolean) => {
    const element = cy.get(`[data-cy="${dataCY}"]`);

    if (shouldBeVisible) element.scrollIntoView().should("be.visible");

    return element;
  },

});

declare global {
  namespace Cypress {
    interface Chainable {
      saveLocalStorage(): void;

      restoreLocalStorage(): void;

      fillForm(name: string,email: string): Chainable

      getElement(dataCY: string, shouldBeVisible?: boolean): Chainable;
    }
  }
}
