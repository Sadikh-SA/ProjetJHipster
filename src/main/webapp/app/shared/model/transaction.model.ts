import { Moment } from 'moment';
import { IClient } from 'app/shared/model/client.model';
import { IUser } from 'app/core/user/user.model';

export interface ITransaction {
  id?: number;
  dateEnvoie?: Moment;
  montant?: number;
  dateRetrait?: Moment;
  comm?: number;
  commExp?: number;
  commRec?: number;
  taxe?: number;
  status?: string;
  codeTransaction?: number;
  commSys?: number;
  idExp?: IClient;
  idDest?: IClient;
  idUserExp?: IUser;
  idUserRec?: IUser;
}

export class Transaction implements ITransaction {
  constructor(
    public id?: number,
    public dateEnvoie?: Moment,
    public montant?: number,
    public dateRetrait?: Moment,
    public comm?: number,
    public commExp?: number,
    public commRec?: number,
    public taxe?: number,
    public status?: string,
    public codeTransaction?: number,
    public commSys?: number,
    public idExp?: IClient,
    public idDest?: IClient,
    public idUserExp?: IUser,
    public idUserRec?: IUser
  ) {}
}
