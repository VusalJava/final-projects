package com.amr.project.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "shop")
public class Shop {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String description;
    private Long countryId;

    @OneToMany (mappedBy = "shop", cascade = CascadeType.ALL)
    private List<Item> items;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "logo_id")
    private Image logo;

    private int count;
    private double rating;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

    @OneToMany (mappedBy = "shop", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Discount> discounts;

    private boolean isModerated = false;
    private boolean isModerateAccept = false;
    private String moderatedRejectReason;
    private boolean isPretendentToBeDeleted = false;

    public Shop(Long id, String name, String email, String phone, String description, Long countryId, List<Item> items, Image logo, int count, double rating, User user, List<Discount> discounts, boolean isModerated, boolean isModerateAccept, String moderatedRejectReason, boolean isPretendentToBeDeleted) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.description = description;
        this.countryId = countryId;
        this.items = items;
        this.logo = logo;
        this.count = count;
        this.rating = rating;
        this.user = user;
        this.discounts = discounts;
        this.isModerated = isModerated;
        this.isModerateAccept = isModerateAccept;
        this.moderatedRejectReason = moderatedRejectReason;
        this.isPretendentToBeDeleted = isPretendentToBeDeleted;
    }

    public Shop() {
    }

    public static ShopBuilder builder() {
        return new ShopBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getDescription() {
        return this.description;
    }

    public Long getCountryId() {
        return this.countryId;
    }

    public List<Item> getItems() {
        return this.items;
    }

    public Image getLogo() {
        return this.logo;
    }

    public int getCount() {
        return this.count;
    }

    public double getRating() {
        return this.rating;
    }

    public User getUser() {
        return this.user;
    }

    public List<Discount> getDiscounts() {
        return this.discounts;
    }

    public boolean isModerated() {
        return this.isModerated;
    }

    public boolean isModerateAccept() {
        return this.isModerateAccept;
    }

    public String getModeratedRejectReason() {
        return this.moderatedRejectReason;
    }

    public boolean isPretendentToBeDeleted() {
        return this.isPretendentToBeDeleted;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setLogo(Image logo) {
        this.logo = logo;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public void setModerated(boolean isModerated) {
        this.isModerated = isModerated;
    }

    public void setModerateAccept(boolean isModerateAccept) {
        this.isModerateAccept = isModerateAccept;
    }

    public void setModeratedRejectReason(String moderatedRejectReason) {
        this.moderatedRejectReason = moderatedRejectReason;
    }

    public void setPretendentToBeDeleted(boolean isPretendentToBeDeleted) {
        this.isPretendentToBeDeleted = isPretendentToBeDeleted;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Shop)) return false;
        final Shop other = (Shop) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$phone = this.getPhone();
        final Object other$phone = other.getPhone();
        if (this$phone == null ? other$phone != null : !this$phone.equals(other$phone)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$countryId = this.getCountryId();
        final Object other$countryId = other.getCountryId();
        if (this$countryId == null ? other$countryId != null : !this$countryId.equals(other$countryId)) return false;
        final Object this$items = this.getItems();
        final Object other$items = other.getItems();
        if (this$items == null ? other$items != null : !this$items.equals(other$items)) return false;
        final Object this$logo = this.getLogo();
        final Object other$logo = other.getLogo();
        if (this$logo == null ? other$logo != null : !this$logo.equals(other$logo)) return false;
        if (this.getCount() != other.getCount()) return false;
        if (Double.compare(this.getRating(), other.getRating()) != 0) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        final Object this$discounts = this.getDiscounts();
        final Object other$discounts = other.getDiscounts();
        if (this$discounts == null ? other$discounts != null : !this$discounts.equals(other$discounts)) return false;
        if (this.isModerated() != other.isModerated()) return false;
        if (this.isModerateAccept() != other.isModerateAccept()) return false;
        final Object this$moderatedRejectReason = this.getModeratedRejectReason();
        final Object other$moderatedRejectReason = other.getModeratedRejectReason();
        if (this$moderatedRejectReason == null ? other$moderatedRejectReason != null : !this$moderatedRejectReason.equals(other$moderatedRejectReason))
            return false;
        if (this.isPretendentToBeDeleted() != other.isPretendentToBeDeleted()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Shop;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $phone = this.getPhone();
        result = result * PRIME + ($phone == null ? 43 : $phone.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $countryId = this.getCountryId();
        result = result * PRIME + ($countryId == null ? 43 : $countryId.hashCode());
        final Object $items = this.getItems();
        result = result * PRIME + ($items == null ? 43 : $items.hashCode());
        final Object $logo = this.getLogo();
        result = result * PRIME + ($logo == null ? 43 : $logo.hashCode());
        result = result * PRIME + this.getCount();
        final long $rating = Double.doubleToLongBits(this.getRating());
        result = result * PRIME + (int) ($rating >>> 32 ^ $rating);
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        final Object $discounts = this.getDiscounts();
        result = result * PRIME + ($discounts == null ? 43 : $discounts.hashCode());
        result = result * PRIME + (this.isModerated() ? 79 : 97);
        result = result * PRIME + (this.isModerateAccept() ? 79 : 97);
        final Object $moderatedRejectReason = this.getModeratedRejectReason();
        result = result * PRIME + ($moderatedRejectReason == null ? 43 : $moderatedRejectReason.hashCode());
        result = result * PRIME + (this.isPretendentToBeDeleted() ? 79 : 97);
        return result;
    }

    public String toString() {
        return "Shop(id=" + this.getId() + ", name=" + this.getName() + ", email=" + this.getEmail() + ", phone=" + this.getPhone() + ", description=" + this.getDescription() + ", countryId=" + this.getCountryId() + ", items=" + this.getItems() + ", logo=" + this.getLogo() + ", count=" + this.getCount() + ", rating=" + this.getRating() + ", user=" + this.getUser() + ", discounts=" + this.getDiscounts() + ", isModerated=" + this.isModerated() + ", isModerateAccept=" + this.isModerateAccept() + ", moderatedRejectReason=" + this.getModeratedRejectReason() + ", isPretendentToBeDeleted=" + this.isPretendentToBeDeleted() + ")";
    }

    public static class ShopBuilder {
        private Long id;
        private String name;
        private String email;
        private String phone;
        private String description;
        private Long countryId;
        private List<Item> items;
        private Image logo;
        private int count;
        private double rating;
        private User user;
        private List<Discount> discounts;
        private boolean isModerated;
        private boolean isModerateAccept;
        private String moderatedRejectReason;
        private boolean isPretendentToBeDeleted;

        ShopBuilder() {
        }

        public ShopBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ShopBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ShopBuilder email(String email) {
            this.email = email;
            return this;
        }

        public ShopBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public ShopBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ShopBuilder countryId(Long countryId) {
            this.countryId = countryId;
            return this;
        }

        public ShopBuilder items(List<Item> items) {
            this.items = items;
            return this;
        }

        public ShopBuilder logo(Image logo) {
            this.logo = logo;
            return this;
        }

        public ShopBuilder count(int count) {
            this.count = count;
            return this;
        }

        public ShopBuilder rating(double rating) {
            this.rating = rating;
            return this;
        }

        public ShopBuilder user(User user) {
            this.user = user;
            return this;
        }

        public ShopBuilder discounts(List<Discount> discounts) {
            this.discounts = discounts;
            return this;
        }

        public ShopBuilder isModerated(boolean isModerated) {
            this.isModerated = isModerated;
            return this;
        }

        public ShopBuilder isModerateAccept(boolean isModerateAccept) {
            this.isModerateAccept = isModerateAccept;
            return this;
        }

        public ShopBuilder moderatedRejectReason(String moderatedRejectReason) {
            this.moderatedRejectReason = moderatedRejectReason;
            return this;
        }

        public ShopBuilder isPretendentToBeDeleted(boolean isPretendentToBeDeleted) {
            this.isPretendentToBeDeleted = isPretendentToBeDeleted;
            return this;
        }

        public Shop build() {
            return new Shop(id, name, email, phone, description, countryId, items, logo, count, rating, user, discounts, isModerated, isModerateAccept, moderatedRejectReason, isPretendentToBeDeleted);
        }

        public String toString() {
            return "Shop.ShopBuilder(id=" + this.id + ", name=" + this.name + ", email=" + this.email + ", phone=" + this.phone + ", description=" + this.description + ", countryId=" + this.countryId + ", items=" + this.items + ", logo=" + this.logo + ", count=" + this.count + ", rating=" + this.rating + ", user=" + this.user + ", discounts=" + this.discounts + ", isModerated=" + this.isModerated + ", isModerateAccept=" + this.isModerateAccept + ", moderatedRejectReason=" + this.moderatedRejectReason + ", isPretendentToBeDeleted=" + this.isPretendentToBeDeleted + ")";
        }
    }
}
