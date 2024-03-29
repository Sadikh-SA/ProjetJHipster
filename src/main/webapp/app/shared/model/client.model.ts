export interface IClient {
  id?: number;
  numeroPiece?: string;
  nomComplet?: string;
  telephone?: string;
}

export class Client implements IClient {
  constructor(public id?: number, public numeroPiece?: string, public nomComplet?: string, public telephone?: string) {}
}
