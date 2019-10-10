import { Component, OnInit } from '@angular/core';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import * as moment from 'moment';
import { JhiAlertService } from 'ng-jhipster';
import { ITransaction, Transaction } from 'app/shared/model/transaction.model';
import { TransactionService } from './transaction.service';
import { IClient } from 'app/shared/model/client.model';
import { ClientService } from 'app/entities/client/client.service';
import { IUser } from 'app/core/user/user.model';
import { UserService } from 'app/core/user/user.service';

@Component({
  selector: 'jhi-transaction-update',
  templateUrl: './transaction-update.component.html'
})
export class TransactionUpdateComponent implements OnInit {
  isSaving: boolean;

  clients: IClient[];

  users: IUser[];
  dateEnvoieDp: any;
  dateRetraitDp: any;

  editForm = this.fb.group({
    id: [],
    dateEnvoie: [null, [Validators.required]],
    montant: [null, [Validators.required]],
    dateRetrait: [],
    comm: [null, [Validators.required]],
    commExp: [null, [Validators.required]],
    commRec: [null, [Validators.required]],
    taxe: [null, [Validators.required]],
    status: [null, [Validators.required]],
    codeTransaction: [null, [Validators.required]],
    commSys: [null, [Validators.required]],
    idExp: [null, Validators.required],
    idDest: [],
    idUserExp: [null, Validators.required],
    idUserRec: []
  });

  constructor(
    protected jhiAlertService: JhiAlertService,
    protected transactionService: TransactionService,
    protected clientService: ClientService,
    protected userService: UserService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ transaction }) => {
      this.updateForm(transaction);
    });
    this.clientService
      .query()
      .pipe(
        filter((mayBeOk: HttpResponse<IClient[]>) => mayBeOk.ok),
        map((response: HttpResponse<IClient[]>) => response.body)
      )
      .subscribe((res: IClient[]) => (this.clients = res), (res: HttpErrorResponse) => this.onError(res.message));
    this.userService
      .query()
      .pipe(
        filter((mayBeOk: HttpResponse<IUser[]>) => mayBeOk.ok),
        map((response: HttpResponse<IUser[]>) => response.body)
      )
      .subscribe((res: IUser[]) => (this.users = res), (res: HttpErrorResponse) => this.onError(res.message));
  }

  updateForm(transaction: ITransaction) {
    this.editForm.patchValue({
      id: transaction.id,
      dateEnvoie: transaction.dateEnvoie,
      montant: transaction.montant,
      dateRetrait: transaction.dateRetrait,
      comm: transaction.comm,
      commExp: transaction.commExp,
      commRec: transaction.commRec,
      taxe: transaction.taxe,
      status: transaction.status,
      codeTransaction: transaction.codeTransaction,
      commSys: transaction.commSys,
      idExp: transaction.idExp,
      idDest: transaction.idDest,
      idUserExp: transaction.idUserExp,
      idUserRec: transaction.idUserRec
    });
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    const transaction = this.createFromForm();
    if (transaction.id !== undefined) {
      this.subscribeToSaveResponse(this.transactionService.update(transaction));
    } else {
      this.subscribeToSaveResponse(this.transactionService.create(transaction));
    }
  }

  private createFromForm(): ITransaction {
    return {
      ...new Transaction(),
      id: this.editForm.get(['id']).value,
      dateEnvoie: this.editForm.get(['dateEnvoie']).value,
      montant: this.editForm.get(['montant']).value,
      dateRetrait: this.editForm.get(['dateRetrait']).value,
      comm: this.editForm.get(['comm']).value,
      commExp: this.editForm.get(['commExp']).value,
      commRec: this.editForm.get(['commRec']).value,
      taxe: this.editForm.get(['taxe']).value,
      status: this.editForm.get(['status']).value,
      codeTransaction: this.editForm.get(['codeTransaction']).value,
      commSys: this.editForm.get(['commSys']).value,
      idExp: this.editForm.get(['idExp']).value,
      idDest: this.editForm.get(['idDest']).value,
      idUserExp: this.editForm.get(['idUserExp']).value,
      idUserRec: this.editForm.get(['idUserRec']).value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ITransaction>>) {
    result.subscribe(() => this.onSaveSuccess(), () => this.onSaveError());
  }

  protected onSaveSuccess() {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError() {
    this.isSaving = false;
  }
  protected onError(errorMessage: string) {
    this.jhiAlertService.error(errorMessage, null, null);
  }

  trackClientById(index: number, item: IClient) {
    return item.id;
  }

  trackUserById(index: number, item: IUser) {
    return item.id;
  }
}
