package sn.sa.devweb.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A Transaction.
 */
@Entity
@Table(name = "transaction")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "date_envoie", nullable = false)
    private LocalDate dateEnvoie;

    @NotNull
    @Column(name = "montant", nullable = false)
    private Double montant;

    @Column(name = "date_retrait")
    private LocalDate dateRetrait;

    @NotNull
    @Column(name = "comm", nullable = false)
    private Double comm;

    @NotNull
    @Column(name = "comm_exp", nullable = false)
    private Double commExp;

    @NotNull
    @Column(name = "comm_rec", nullable = false)
    private Double commRec;

    @NotNull
    @Column(name = "taxe", nullable = false)
    private Double taxe;

    @NotNull
    @Column(name = "status", nullable = false)
    private String status;

    @NotNull
    @Column(name = "code_transaction", nullable = false, unique = true)
    private Double codeTransaction;

    @NotNull
    @Column(name = "comm_sys", nullable = false)
    private Double commSys;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties("transactions")
    private Client idExp;

    @ManyToOne
    @JsonIgnoreProperties("transactions")
    private Client idDest;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties("transactions")
    private User idUserExp;

    @ManyToOne
    @JsonIgnoreProperties("transactions")
    private User idUserRec;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateEnvoie() {
        return dateEnvoie;
    }

    public Transaction dateEnvoie(LocalDate dateEnvoie) {
        this.dateEnvoie = dateEnvoie;
        return this;
    }

    public void setDateEnvoie(LocalDate dateEnvoie) {
        this.dateEnvoie = dateEnvoie;
    }

    public Double getMontant() {
        return montant;
    }

    public Transaction montant(Double montant) {
        this.montant = montant;
        return this;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public LocalDate getDateRetrait() {
        return dateRetrait;
    }

    public Transaction dateRetrait(LocalDate dateRetrait) {
        this.dateRetrait = dateRetrait;
        return this;
    }

    public void setDateRetrait(LocalDate dateRetrait) {
        this.dateRetrait = dateRetrait;
    }

    public Double getComm() {
        return comm;
    }

    public Transaction comm(Double comm) {
        this.comm = comm;
        return this;
    }

    public void setComm(Double comm) {
        this.comm = comm;
    }

    public Double getCommExp() {
        return commExp;
    }

    public Transaction commExp(Double commExp) {
        this.commExp = commExp;
        return this;
    }

    public void setCommExp(Double commExp) {
        this.commExp = commExp;
    }

    public Double getCommRec() {
        return commRec;
    }

    public Transaction commRec(Double commRec) {
        this.commRec = commRec;
        return this;
    }

    public void setCommRec(Double commRec) {
        this.commRec = commRec;
    }

    public Double getTaxe() {
        return taxe;
    }

    public Transaction taxe(Double taxe) {
        this.taxe = taxe;
        return this;
    }

    public void setTaxe(Double taxe) {
        this.taxe = taxe;
    }

    public String getStatus() {
        return status;
    }

    public Transaction status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getCodeTransaction() {
        return codeTransaction;
    }

    public Transaction codeTransaction(Double codeTransaction) {
        this.codeTransaction = codeTransaction;
        return this;
    }

    public void setCodeTransaction(Double codeTransaction) {
        this.codeTransaction = codeTransaction;
    }

    public Double getCommSys() {
        return commSys;
    }

    public Transaction commSys(Double commSys) {
        this.commSys = commSys;
        return this;
    }

    public void setCommSys(Double commSys) {
        this.commSys = commSys;
    }

    public Client getIdExp() {
        return idExp;
    }

    public Transaction idExp(Client client) {
        this.idExp = client;
        return this;
    }

    public void setIdExp(Client client) {
        this.idExp = client;
    }

    public Client getIdDest() {
        return idDest;
    }

    public Transaction idDest(Client client) {
        this.idDest = client;
        return this;
    }

    public void setIdDest(Client client) {
        this.idDest = client;
    }

    public User getIdUserExp() {
        return idUserExp;
    }

    public Transaction idUserExp(User user) {
        this.idUserExp = user;
        return this;
    }

    public void setIdUserExp(User user) {
        this.idUserExp = user;
    }

    public User getIdUserRec() {
        return idUserRec;
    }

    public Transaction idUserRec(User user) {
        this.idUserRec = user;
        return this;
    }

    public void setIdUserRec(User user) {
        this.idUserRec = user;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Transaction)) {
            return false;
        }
        return id != null && id.equals(((Transaction) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Transaction{" +
            "id=" + getId() +
            ", dateEnvoie='" + getDateEnvoie() + "'" +
            ", montant=" + getMontant() +
            ", dateRetrait='" + getDateRetrait() + "'" +
            ", comm=" + getComm() +
            ", commExp=" + getCommExp() +
            ", commRec=" + getCommRec() +
            ", taxe=" + getTaxe() +
            ", status='" + getStatus() + "'" +
            ", codeTransaction=" + getCodeTransaction() +
            ", commSys=" + getCommSys() +
            "}";
    }
}
